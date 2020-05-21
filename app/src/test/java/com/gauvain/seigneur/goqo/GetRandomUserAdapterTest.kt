package com.gauvain.seigneur.goqo

import com.gauvain.seigneur.goqo.dataAdapter.RandomUserService
import com.gauvain.seigneur.goqo.dataAdapter.adapter.GetRandomUsersAdapter
import com.gauvain.seigneur.goqo.domain.RequestExceptionType
import com.gauvain.seigneur.goqo.domain.provider.GetRandomUsersException
import com.gauvain.seigneur.goqo.mock.ResponseGsonObjectMock
import com.gauvain.seigneur.goqo.mock.ServiceMock
import com.google.common.truth.Truth
import org.junit.Test
import org.junit.Before
import org.mockito.MockitoAnnotations

class GetRandomUserAdapterTest {

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun `When we receive only a message from provider it must return Exception`() {
        val messageResponse: RandomUserService =
            ServiceMock.createServiceWithResponses(ResponseGsonObjectMock.createMessageResponse())
        val provider = GetRandomUsersAdapter(messageResponse)
        val result = runCatching {
            provider.get(0, 0)
        }
        Truth.assertThat(result.exceptionOrNull()).isNotNull()
        Truth.assertThat(result.exceptionOrNull()).isInstanceOf(GetRandomUsersException::class.java)
        Truth.assertThat((result.exceptionOrNull() as GetRandomUsersException).type).isEqualTo(
            RequestExceptionType.UNAUTHORIZED
        )
        Truth.assertThat((result.exceptionOrNull() as GetRandomUsersException).description).isEqualTo(
            "oops")
    }

}
