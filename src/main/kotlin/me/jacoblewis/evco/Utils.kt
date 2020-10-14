package me.jacoblewis.evco

import javax.servlet.http.HttpServletRequest

val HttpServletRequest.baseUrl: String
    get() = "$scheme://$serverName${if (serverName == "localhost") ":8080" else ""}"