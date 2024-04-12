package asb.m07.m07_04_01.stylingmyapp

import java.io.Serializable

class Videojoc (val titol: String, val imatge: Int, val jugadors: Int): Serializable
//Serializable permet que es pugui passar entre activities/fragments amb un intent.PutExtra
