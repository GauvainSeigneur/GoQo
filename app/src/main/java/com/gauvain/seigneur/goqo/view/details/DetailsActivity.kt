package com.gauvain.seigneur.goqo.view.details

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import coil.api.load
import com.gauvain.seigneur.goqo.R
import com.gauvain.seigneur.goqo.presentation.data.UserItemData
import com.google.android.material.chip.Chip
import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity : AppCompatActivity() {

    companion object {

        private const val DATA_KEY = "data_key"

        fun newIntent(
            context: Context,
            data: UserItemData
        ): Intent =
            Intent(context, DetailsActivity::class.java)
                .putExtra(DATA_KEY, data)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        toolbar.setNavigationOnClickListener {
            onBackPressed()
        }
        val details: UserItemData? = intent.getParcelableExtra(DATA_KEY)
        displayData(details)

    }

    private fun displayData(data: UserItemData?) {
        data?.let {
            picView.load(it.picture
            ) {
                placeholder(R.drawable.ic_account_circle_black_24dp)
                error(R.drawable.ic_account_circle_black_24dp)
                fallback(R.drawable.ic_account_circle_black_24dp)
            }
            userNameView.text = "${it.firstName} ${it.lastName}"
        }?: displayNoData()

    }

    private fun displayNoData() {
        finish()
        Toast.makeText(this, getString(R.string.common_error_info), Toast.LENGTH_LONG).show()
    }

}
