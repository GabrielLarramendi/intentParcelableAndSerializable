package dominando.android.testeskotlin

import android.os.Parcel
import android.os.Parcelable

class Client(var code: Int, var name: String?):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) { //Transforma os atributos da classe em bytes
        parcel.writeInt(code)
        parcel.writeString(name)
    }

    override fun describeContents(): Int { //Gera um identificador unico para a classe
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Client> {
        override fun createFromParcel(parcel: Parcel): Client {
            return Client(parcel)
        }

        override fun newArray(size: Int): Array<Client?> {
            return arrayOfNulls(size)
        }
    }
}