package dominando.android.testeskotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonToast = findViewById<Button>(R.id.mainButtonToast)
        val editText = findViewById<EditText>(R.id.editTextField)
        val buttonChangeActivity = findViewById<Button>(R.id.changeActivityButton)
        val buttonParcel = findViewById<Button>(R.id.buttonParcel)
        val buttonSerializable = findViewById<Button>(R.id.buttonSerializable)

        buttonToast.setOnClickListener(object: View.OnClickListener {
            override fun onClick(v: View?) {
                val text = editText.text.toString()
                Toast.makeText(this@MainActivity, text, Toast.LENGTH_SHORT).show()
            }
        })

        buttonChangeActivity.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                val intentOpenActivity2 = Intent(this@MainActivity, Activity02Intent::class.java)
                intentOpenActivity2.putExtra("name", "Gabriel")
                intentOpenActivity2.putExtra("age", 26)
                startActivity(intentOpenActivity2)
            }
        })

        buttonParcel.setOnClickListener {
            val client = Client(1, "Gabriel")
            val intent = Intent(this, Activity02Intent::class.java)
            intent.putExtra("client", client)
            startActivity(intent)
        }

        buttonSerializable.setOnClickListener {
            val intent = Intent(this, Activity02Intent::class.java)
            intent.putExtra("person", Person("Laura", 25))
            startActivity(intent)
        }
    }
}