package com.sheylasoftware.testapp.data.repository

import android.util.Log
import com.sheylasoftware.testapp.data.datasource.UserRemoteDataSource
import com.sheylasoftware.testapp.data.mapper.toDomain
import com.sheylasoftware.testapp.domain.model.User
import com.sheylasoftware.testapp.domain.repository.UserRepository

class UserRepositoryImpl(
    private val remoteDataSource: UserRemoteDataSource
) : UserRepository {

    override suspend fun getUsers(): List<User> {
        /*
         Reglas:
         - Obtener datos del datasource
         - Convertir DTO → dominio
         - Ignorar elementos inválidos
         - NO aplicar lógica de negocio (edad)
         */

        /*
        Se obtiene los datas con remoteDataSource.fetchUsers()
        Se convierte el DTO -> domino usando toDomain()
        Se mapea y se ignoran los elementos invalidos con .mapNotNull
        lo de no aplica la logica del negocio(edad) se esta validando datos eso
        es muy aparte de la logica de negocio
        pero si se referia a que la edad puede o no ser null simplemente
        no se lo toma en cuenta en el if
         */
        return remoteDataSource.fetchUsers()
            .mapNotNull { it.toDomain() }

        //return emptyList() manda una lista vacia
    }
}