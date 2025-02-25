package com.jennysival.nookapp.repository

import com.jennysival.nookapp.R
import com.jennysival.nookapp.data.local.FeaturesModel
import org.junit.Assert
import org.junit.Test

class FeaturesRepositoryTest {

    @Test
    fun `when call getFeaturesList should return features list`() {
        val repository = FeaturesRepository()

        val listMock = listOf(
            FeaturesModel(name = "Missões Diárias", icon = R.drawable.missoes),
            FeaturesModel(name = "Conquistas", icon = R.drawable.conquistas),
            FeaturesModel(name = "Criaturas", icon = R.drawable.criaturas),
            FeaturesModel(name = "Receitas", icon = R.drawable.receitas),
            FeaturesModel(name = "Catalogo", icon = R.drawable.catalogo),
            FeaturesModel(name = "Visitantes e Moradores", icon = R.drawable.visitantes),
            FeaturesModel(name = "Minha Ilha", icon = R.drawable.ilha),
            FeaturesModel(name = "Músicas", icon = R.drawable.musicas),
            FeaturesModel(name = "Amigos", icon = R.drawable.amigos),
            FeaturesModel(name = "Finanças", icon = R.drawable.financas),
            FeaturesModel(name = "Flores", icon = R.drawable.flores),
            FeaturesModel(name = "Sobre o App", icon = R.drawable.sobre),
            FeaturesModel(name = "Agenda", icon = R.drawable.agenda),
            FeaturesModel(name = "Fósseis", icon = R.drawable.fosseis),
            FeaturesModel(name = "Gyroids", icon = R.drawable.gyroids)
        )

        Assert.assertEquals(repository.getFeaturesList(), listMock)
    }
}