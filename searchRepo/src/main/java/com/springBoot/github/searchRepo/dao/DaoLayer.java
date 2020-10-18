package com.springBoot.github.searchRepo.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Repository;

import com.springBoot.github.searchRepo.models.Repos;

@Repository
public class DaoLayer {
	private static String REPO_URL = "https://api.github.com/search/issues?q=language:";

	List<Repos> repos;

	public List<Repos> getReposByLanguage(String language) throws IOException, InterruptedException, JSONException {
		// TODO Auto-generated method stub
		repos = new ArrayList();
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(REPO_URL + language)).build();
		HttpResponse<String> httpResponse = client.send(request, HttpResponse.BodyHandlers.ofString());
		StringReader jsonBodyReader = new StringReader(httpResponse.body());
		BufferedReader in = new BufferedReader(jsonBodyReader);
		String inputLine;
		StringBuffer response = new StringBuffer();
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		JSONObject jsonResponseBody = new JSONObject(response.toString());
		if (jsonResponseBody.has("errors")) {
			return null;
		} else {
			if (jsonResponseBody.has("items")) {
				JSONArray jsonArray = jsonResponseBody.getJSONArray("items");

				for (int i = 0; i < jsonArray.length(); i++) {
					Repos repo = new Repos();
					JSONObject json = jsonArray.getJSONObject(i);
					repo.setId(json.getString("id"));
					repo.setTitle(json.getString("title"));
					repo.setUrl(json.getString("url"));
					repo.setUser(json.getJSONObject("user").getString("login"));
					repos.add(repo);
				}
			}
		}
		return repos;
	}

}
