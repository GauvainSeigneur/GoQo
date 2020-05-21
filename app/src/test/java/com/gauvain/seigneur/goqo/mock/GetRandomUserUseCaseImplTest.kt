package com.gauvain.seigneur.goqo.mock

import com.gauvain.seigneur.c.domain.ErrorType
import com.gauvain.seigneur.goqo.domain.Outcome
import com.gauvain.seigneur.goqo.domain.RequestExceptionType
import com.gauvain.seigneur.goqo.domain.provider.GetRandomUsersException
import com.gauvain.seigneur.goqo.domain.provider.GetRandomUsersProvider
import com.gauvain.seigneur.goqo.domain.usecase.GetRandomUsersUseCaseImpl
import com.google.common.truth.Truth.assertThat
import com.nhaarman.mockitokotlin2.given
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Test
import org.mockito.*

class GetRandomUserUseCaseImplTest {

    @Mock
    private lateinit var provider: GetRandomUsersProvider
    @InjectMocks
    private lateinit var useCase: GetRandomUsersUseCaseImpl

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun `When we receive ERROR UNKNOWN from provider adapter must return OutCome Error`() {
        runBlockingTest {
            given(provider.get (0, 0)).willThrow(
                GetRandomUsersException(RequestExceptionType.ERROR_UNKNOWN)
            )
            val outcome = useCase.invoke(0,0)
            assertThat(outcome).isNotNull()
            assertThat(outcome).isEqualTo(Outcome.Error(ErrorType.ERROR_UNKNOWN))
        }
    }

    @Test
    fun `When we receive ERROR BODY NULL from provider adapter must return OutCome Error`() {
        runBlockingTest {
            given(provider.get (0, 0)).willThrow(
                GetRandomUsersException(RequestExceptionType.BODY_NULL)
            )
            val outcome = useCase.invoke(0,0)
            assertThat(outcome).isNotNull()
            assertThat(outcome).isEqualTo(Outcome.Error(ErrorType.ERROR_UNKNOWN))
        }
    }

    @Test
    fun `When we receive UNAUTHORIZED from provider adapter must return OutCome Error`() {
        runBlockingTest {
            given(provider.get (0, 0)).willThrow(
                GetRandomUsersException(RequestExceptionType.UNAUTHORIZED)
            )
            val outcome = useCase.invoke(0,0)
            assertThat(outcome).isNotNull()
            assertThat(outcome).isEqualTo(Outcome.Error(ErrorType.ERROR_UNAUTHORIZED))
        }
    }

    @Test
    fun `When we receive CONNECTION_LOST from provider adapter must return OutCome Error`() {
        runBlockingTest {
            given(provider.get (0, 0)).willThrow(
                GetRandomUsersException(RequestExceptionType.CONNECTION_LOST)
            )
            val outcome = useCase.invoke(0,0)
            assertThat(outcome).isNotNull()
            assertThat(outcome).isEqualTo(Outcome.Error(ErrorType.ERROR_CONNECTION_LOST))
        }
    }

    @Test
    fun `When we receive UNKNOWN_HOST from provider adapter must return OutCome Error`() {
        runBlockingTest {
            given(provider.get (0, 0)).willThrow(
                GetRandomUsersException(RequestExceptionType.UNKNOWN_HOST)
            )
            val outcome = useCase.invoke(0,0)
            assertThat(outcome).isNotNull()
            assertThat(outcome).isEqualTo(Outcome.Error(ErrorType.ERROR_UNKNOWN_HOST))
        }
    }

    @Test
    fun `When we receive SERVER_INTERNAL_ERROR from provider adapter must return OutCome Error`() {
        runBlockingTest {
            given(provider.get (0, 0)).willThrow(
                GetRandomUsersException(RequestExceptionType.SERVER_INTERNAL_ERROR)
            )
            val outcome = useCase.invoke(0,0)
            assertThat(outcome).isNotNull()
            assertThat(outcome).isEqualTo(Outcome.Error(ErrorType.ERROR_INTERNAL_SERVER))
        }
    }

    @Test
    fun `When we receive UNKNOWN_OBJECT from provider adapter must return OutCome Error`() {
        runBlockingTest {
            given(provider.get (0, 0)).willThrow(
                GetRandomUsersException(RequestExceptionType.UNKNOWN_OBJECT)
            )
            val outcome = useCase.invoke(0,0)
            assertThat(outcome).isNotNull()
            assertThat(outcome).isEqualTo(Outcome.Error(ErrorType.ERROR_UNKNOWN))
        }
    }
}