package mx.veedsdev.com.registrodesuperheroes

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
class Superhero ( val name : String, val alterEgo : String, val biography : String, val power : Float) :
    Parcelable