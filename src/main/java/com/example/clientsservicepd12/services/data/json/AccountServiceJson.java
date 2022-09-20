package com.example.clientsservicepd12.services.data.json;

import com.example.clientsservicepd12.models.Account;
import com.example.clientsservicepd12.services.data.AccountService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static java.nio.file.StandardOpenOption.CREATE;
import static java.nio.file.StandardOpenOption.WRITE;

@Service
public class AccountServiceJson implements AccountService {
	private final Path path = Path.of("accounts.json");

	private Gson gson() {
		return new GsonBuilder().create();
	}

	private long newId(List<Account> list) {
		if (list.size() > 0)
			return list.get(list.size() - 1).getId() + 1;
		return 1;
	}

	@Override
	public List<Account> findAll() {
		try {
			String json = Files.readString(path);
			return gson().fromJson(json, new TypeToken<List<Account>>() {
			}.getType());
		}
		catch (IOException ignored) {
		}
		return new ArrayList<>();
	}

	@Override
	public Account save(Account account) {
		List<Account> list = findAll();
		account.setId(newId(list));
		list.add(account);
		String json = gson().toJson(list);
		try {
			Files.writeString(path, json, CREATE, WRITE);
			return account;
		}
		catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
