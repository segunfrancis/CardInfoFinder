package com.mayokunadeniyi.data.mapper

import com.mayokunadeniyi.data.remote.response.Bank
import com.mayokunadeniyi.data.remote.response.CardInfoResponse
import com.mayokunadeniyi.data.remote.response.Country
import com.mayokunadeniyi.domain.models.CardInfo

/**
 * Created by Mayokun Adeniyi on 22/07/2020.
 */

class CardInfoMapperRemote : BaseMapperRepository<CardInfoResponse, CardInfo> {
    override fun transform(type: CardInfoResponse) = CardInfo(
        bank = type.bank?.name ?: "",
        brand = type.brand ?: "",
        country = type.country?.name ?: "",
        type = type.type ?: ""
    )

    override fun transformToRepository(type: CardInfo) = CardInfoResponse(
        bank = Bank(name = type.bank),
        brand = type.brand,
        country = Country(name = type.country),
        type = type.type
    )
}