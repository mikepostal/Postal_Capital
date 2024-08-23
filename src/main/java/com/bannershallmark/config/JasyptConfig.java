package com.bannershallmark.config;

import org.jasypt.util.text.BasicTextEncryptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JasyptConfig {

	@Bean("jasyptEncryptor")
	public BasicTextEncryptor textEncryptor() {
		BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
		textEncryptor.setPassword("bannershallmark");
		return textEncryptor;
	}
}
