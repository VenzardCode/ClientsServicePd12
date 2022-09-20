package com.example.clientsservicepd12.services.data.qualifiers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;

@Qualifier("accountServiceDb")
@Retention(RetentionPolicy.RUNTIME)
@Target({FIELD})
public @interface AccountServiceQualifier {
}
