package com.library.src

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SrcApplication

fun main(args: Array<String>) {
	runApplication<SrcApplication>(*args)
}
