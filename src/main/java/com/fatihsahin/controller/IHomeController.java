package com.fatihsahin.controller;

import com.fatihsahin.dto.DtoHome;

public interface IHomeController {

    public DtoHome findHomeById( Long id );
}
