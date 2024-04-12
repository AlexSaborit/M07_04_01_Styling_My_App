package asb.m07.m07_04_01.stylingmyapp

import java.io.Serializable

class Figura (val nom: String,
              val imatge: Int,
              val preu: Double,
              origen: String,
              escala: Int,
              articulada: Boolean): Serializable
//Serializable permet que es pugui passar entre activities/fragments amb un intent.PutExtra
