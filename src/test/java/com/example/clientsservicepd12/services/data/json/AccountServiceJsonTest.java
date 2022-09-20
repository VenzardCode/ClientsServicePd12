package com.example.clientsservicepd12.services.data.json;

import com.example.clientsservicepd12.models.Account;
import com.example.clientsservicepd12.models.Client;
import com.example.clientsservicepd12.models.Phone;
import com.example.clientsservicepd12.services.data.AccountService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
class AccountServiceJsonTest {
	@Qualifier("accountServiceJson")
	@Autowired
	AccountService accountService;

	@Order(1)
	@Test
	void save() {
		Random random = new Random();
		Account account = new Account(0L, random.nextInt(10) * 10, null);
		accountService.save(account);
	}

	@Order(2)
	@Test
	void findAll() {
		List<Account> list = accountService.findAll();
		System.err.println(list);
	}

	@Test
	public void method() {
		Client client = new Client(0, "a", "a", "v",
			LocalDate.now(), Client.Gender.FEMALE, "e",
			Set.of(
				new Phone(0L, "111", null),
				new Phone(0L, "222", null)
			), null);
		GsonBuilder builder = new GsonBuilder();
		builder.registerTypeAdapter(Client.class, new TypeAdapter<Client>() {
			@Override
			public void write(JsonWriter jsonWriter, Client client) throws IOException {
				jsonWriter.beginObject();
				jsonWriter.name("surname").value(client.getSurname());
				jsonWriter.name("birthDate").value(client.getBirthDate().toString());
				//>phones
				jsonWriter.name("phones").beginArray();
				if (client.getPhones() != null) {
					for (Phone phone : client.getPhones()) {
						jsonWriter.beginObject();
						jsonWriter.name("phone").value(phone.getPhone());
						jsonWriter.endObject();
					}
				}
				jsonWriter.endArray();
				//<phones
				jsonWriter.endObject();
			}

			@Override
			public Client read(JsonReader jsonReader) throws IOException {
				Client client = new Client();
				jsonReader.beginObject();
				jsonReader.nextName();
				client.setSurname(jsonReader.nextString());
				jsonReader.nextName();
				client.setBirthDate(LocalDate.parse(jsonReader.nextString()));
				//ph
				jsonReader.nextName();
				jsonReader.beginArray();
				while (jsonReader.hasNext()) {
					jsonReader.beginObject();
					jsonReader.nextName();
					jsonReader.nextString();
					jsonReader.endObject();
				}
				jsonReader.endArray();
				//ph
				jsonReader.endObject();
				return client;
			}
		});
		Gson gson = builder.create();
		String json = gson.toJson(client);
		System.err.println(json);
		client = gson.fromJson(json, Client.class);
		System.err.println(client);
	}
}