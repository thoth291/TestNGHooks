package clients
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory
import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.fasterxml.jackson.module.kotlin.MissingKotlinParameterException

import io.restassured.RestAssured.given
import org.hamcrest.Matchers.*

import java.nio.file.Files
import java.nio.file.Paths

/**
 *
 *  application.yaml
 *
    qaseio:
      api_token_key: YOUR_TOKEN
 *
 * */

data class ProductProperties(
    val api_token_key: String?
)

data class Config(
    val qaseio: ProductProperties?
)

class QaseioClient {

    lateinit var accessToken: String

    fun getConfig(): Config? {
        val mapper = ObjectMapper(YAMLFactory()).registerModule(KotlinModule())
        val file = Files.newBufferedReader(Paths.get("src/test/resources/application.yaml"))

        return try {
            file.use {
                mapper.readValue(it, Config::class.java)
            }
        } catch (exception: MissingKotlinParameterException) {
            println("Could not read YAML file!")
            println(exception.message)
            Config(qaseio=null)
        }
    }

    fun setupClient(){

        val config = getConfig()
        accessToken = config!!.qaseio?.api_token_key.toString()
        /**
         *
         {
            "status": true,
            "result": {
                "total": 0,
                "filtered": 0,
                "count": 0,
                "entities": []
            }
        }
         * */

        given()
            .param("limit","10")
            .param("offset","0")
            .header("Accept", "application/json")
            .header("Token", accessToken)
        .`when`()
            .get("https://api.qase.io/v1/attachment")
        .then()
            .log().all()
            .statusCode(200)
            .body("status",equalTo(true))
            .body("result", notNullValue())

    }

}