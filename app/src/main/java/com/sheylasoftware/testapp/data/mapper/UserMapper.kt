package com.sheylasoftware.testapp.data.mapper

import com.sheylasoftware.testapp.data.model.UserDto
import com.sheylasoftware.testapp.domain.model.User

fun UserDto.toDomain(): User? {
    /*
     Reglas:
     - Si id, fullName o age son null → devolver null
     - Mapear fullName → name
     - NO lanzar excepciones
     */
    //return null  esta retornando siempre nulos

    /*
    Como no se desea mostrar los datos si una de las variables es null
    con un if podemos decir que si alguno es null retorne null caso contrario
    retorne normalmente los datos
    */
    if (id == null || fullName == null || age == null) {
        return null
    }

    return User(
        id = id,
        name = fullName,
        age = age
    )
}