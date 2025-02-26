package com.jennysival.nookapp.repository

import com.jennysival.nookapp.R
import com.jennysival.nookapp.data.local.FeaturesModel
import com.jennysival.nookapp.utils.NOOKAPP_AGENDA
import com.jennysival.nookapp.utils.NOOKAPP_AMIGOS
import com.jennysival.nookapp.utils.NOOKAPP_CATALOGO
import com.jennysival.nookapp.utils.NOOKAPP_CONQUISTAS
import com.jennysival.nookapp.utils.NOOKAPP_CRIATURAS
import com.jennysival.nookapp.utils.NOOKAPP_FINANCAS
import com.jennysival.nookapp.utils.NOOKAPP_FLORES
import com.jennysival.nookapp.utils.NOOKAPP_FOSSEIS
import com.jennysival.nookapp.utils.NOOKAPP_GYROIDS
import com.jennysival.nookapp.utils.NOOKAPP_MINHA_ILHA
import com.jennysival.nookapp.utils.NOOKAPP_MISSOES
import com.jennysival.nookapp.utils.NOOKAPP_MUSICAS
import com.jennysival.nookapp.utils.NOOKAPP_RECEITAS
import com.jennysival.nookapp.utils.NOOKAPP_SOBRE
import com.jennysival.nookapp.utils.NOOKAPP_VISITANTES
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class FeaturesRepositoryTest {

    private lateinit var subject: FeaturesRepository
    private lateinit var expectedList: List<FeaturesModel>

    @Before
    fun setup() {
        subject = FeaturesRepository()
        expectedList = createExpectedList()
    }

    @Test
    fun `when getFeaturesList is called should return the correct list`() {
        val result = subject.getFeaturesList()

        assertEquals(expectedList, result)
    }

    @Test
    fun `when getFeaturesList is called should return a list with the correct size`() {
        val result = subject.getFeaturesList()

        assertEquals(expectedList.size, result.size)
    }

    @Test
    fun `when getFeaturesList is called should return a list containing the correct items`() {
        val result = subject.getFeaturesList()

        assertTrue(result.containsAll(expectedList))
    }

    private fun createExpectedList(): List<FeaturesModel> {
        val missoesDiarias = FeaturesModel(
            name = NOOKAPP_MISSOES,
            icon = R.drawable.missoes
        )

        val conquistas = FeaturesModel(
            name = NOOKAPP_CONQUISTAS,
            icon = R.drawable.conquistas
        )

        val criaturas = FeaturesModel(
            name = NOOKAPP_CRIATURAS,
            icon = R.drawable.criaturas
        )

        val receitas = FeaturesModel(
            name = NOOKAPP_RECEITAS,
            icon = R.drawable.receitas
        )

        val catalogo = FeaturesModel(
            name = NOOKAPP_CATALOGO,
            icon = R.drawable.catalogo
        )

        val visitantesEMoradores = FeaturesModel(
            name = NOOKAPP_VISITANTES,
            icon = R.drawable.visitantes
        )

        val minhaIlha = FeaturesModel(
            name = NOOKAPP_MINHA_ILHA,
            icon = R.drawable.ilha
        )

        val musicas = FeaturesModel(
            name = NOOKAPP_MUSICAS,
            icon = R.drawable.musicas
        )

        val amigos = FeaturesModel(
            name = NOOKAPP_AMIGOS,
            icon = R.drawable.amigos
        )

        val financas = FeaturesModel(
            name = NOOKAPP_FINANCAS,
            icon = R.drawable.financas
        )

        val flores = FeaturesModel(
            name = NOOKAPP_FLORES,
            icon = R.drawable.flores
        )

        val info = FeaturesModel(
            name = NOOKAPP_SOBRE,
            icon = R.drawable.sobre
        )

        val agenda = FeaturesModel(
            name = NOOKAPP_AGENDA,
            icon = R.drawable.agenda
        )

        val fosseis = FeaturesModel(
            name = NOOKAPP_FOSSEIS,
            icon = R.drawable.fosseis
        )

        val gyroids = FeaturesModel(
            name = NOOKAPP_GYROIDS,
            icon = R.drawable.gyroids
        )

        return listOf(
            missoesDiarias,
            conquistas,
            criaturas,
            receitas,
            catalogo,
            visitantesEMoradores,
            minhaIlha,
            musicas,
            amigos,
            financas,
            flores,
            info,
            agenda,
            fosseis,
            gyroids
        )
    }
}