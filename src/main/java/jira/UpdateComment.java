package jira;

import static io.restassured.RestAssured.given;

import io.restassured.path.json.JsonPath;

public class UpdateComment {

	public static void updateComment(String sessionid, String issueid, String commentid) {
		String updatedcomment = given().header("Cookie", sessionid).header("Content-Type", "application/json")
				.body("{\r\n" + 
						"    \"body\": \"I am updating the comment from API request\"\r\n" + 
						"}")
				.when().put("/rest/api/2/issue/"+issueid+"/comment/"+commentid)
				.then().statusCode(200).extract().asString();
				JsonPath jsonpath5 = new JsonPath(updatedcomment);
				System.out.println("Updated comment: "+jsonpath5.getString("body"));
	}
}
