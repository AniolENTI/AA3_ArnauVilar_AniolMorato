package com.enti.dostres.cdi.arnauvilar.blocfirebase.fragments.screens.chat

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.enti.dostres.cdi.arnauvilar.blocfirebase.MyApp
import com.enti.dostres.cdi.arnauvilar.blocfirebase.R
import com.enti.dostres.cdi.arnauvilar.blocfirebase.clases.firebase.FB
import com.enti.dostres.cdi.arnauvilar.blocfirebase.fragments.components.AppDrawer
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputLayout

class ChatScreen: Fragment() {

    lateinit var fragmentView: View
    val messageTable by lazy { fragmentView.findViewById<RecyclerView>(R.id.chat_messages_recycler) }
    val messageInput by lazy { fragmentView.findViewById<TextInputLayout>(R.id.chat_messages_input) }
    val messageImage by lazy { fragmentView.findViewById<ImageView>(R.id.chat_messages_image_container) }

    val galleryLauncher = registerForActivityResult(ActivityResultContracts.GetContent()) { galleryUri ->
        onImagePicked(galleryUri)
    }
    var currentImageUri: Uri? = null

    val messagesAdapter by lazy { MessagesAdapter(messageTable)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentView = inflater.inflate(R.layout.screen_chat, container, false)
        return fragmentView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        messageTable.layoutManager = LinearLayoutManager(MyApp.get())
        messageTable.adapter = messagesAdapter

        messageInput.setStartIconOnClickListener {
            openImagePicker()
        }

        messageInput.setEndIconOnClickListener {
            sendMessage()
        }
    }

    fun sendMessage() {

        if(!FB.auth.isLoginActive()) {

            MyApp.get().closeKeyboard(messageInput)
            AppDrawer.get().openLogin()

            return
        }

        val inputText = messageInput.editText?.text.toString()
        val text = if(inputText != "") inputText else null

        val imageUri = currentImageUri ?: kotlin.run {
            messagesAdapter.addMessage(text, null)
            messageInput.editText?.text?.clear()

            return
        }

        FB.storage.saveImage(imageUri,
            onSuccess = {newImageUri ->
                messagesAdapter.addMessage(text, newImageUri.toString())

                messageInput.editText?.text?.clear()

                onImagePicked(null)

            },
            onFailure = {
                Snackbar.make(AppDrawer.get().fragmentView,
                getString(R.string.chat_upload_image_error),
                Snackbar.LENGTH_LONG
                ).show()
            }
        )

        messagesAdapter.addMessage(text, null)
        messageInput.editText?.text?.clear()
    }

    fun openImagePicker() {
        galleryLauncher.launch("image/*")
    }

    fun onImagePicked(galleryUri: Uri?) {
        currentImageUri = galleryUri
        messageImage.setImageURI(galleryUri)

        currentImageUri?.let {
            messageImage.visibility = View.VISIBLE
        } ?: kotlin.run {
            messageImage.visibility = View.GONE
        }
    }
}