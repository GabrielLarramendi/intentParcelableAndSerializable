package dominando.android.testeskotlin

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import org.parceler.Parcels

class Activity02Intent : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_activity02_intent)

        val dataClientText = findViewById<TextView>(R.id.textViewResponseIntent)

        val name = intent.getStringExtra(   "name")
        val age = intent.getIntExtra("age", -100)

        val client = intent.getSerializableExtra("client") as Client?

        val person = intent.getSerializableExtra("person") as Person?

        dataClientText.text = if (client != null) {
            getString(R.string.intentParcelResponseString, client.name, client.code)
        } else if (person != null) {
            getString(R.string.intentResponseString, person.name, person.age)
        } else {
            getString(R.string.intentResponseString, name, age)
        }
    }
}