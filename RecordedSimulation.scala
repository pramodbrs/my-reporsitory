package test1

import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class RecordedSimulation extends Simulation {

	val httpProtocol = http
		.baseUrl("https://www.saucedemo.com")
		.inferHtmlResources(BlackList(""".*\.js""", """.*\.css""", """.*\.gif""", """.*\.jpeg""", """.*\.jpg""", """.*\.ico""", """.*\.woff""", """.*\.woff2""", """.*\.(t|o)tf""", """.*\.png""", """.*detectportal\.firefox\.com.*"""), WhiteList())
		.userAgentHeader("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/90.0.4430.93 Safari/537.36")

	val headers_0 = Map(
		"sec-ch-ua" -> """ Not A;Brand";v="99", "Chromium";v="90", "Google Chrome";v="90""",
		"sec-ch-ua-mobile" -> "?0")

	val searchFeeder = csv("data/search.csv").random

	val scn = scenario("RecordedSimulation")
		.feed(searchFeeder)
		.exec(http("request_0")
			.get("/static/media/close@3x.3a2a3ada.svg")
			.headers(headers_0)
			.resources(http("request_1")
			.get("/static/media/${searchCriterion}")
			.headers(headers_0),
            http("request_2")
			.get("/static/media/logo3x.096bf4a7.svg")
			.headers(headers_0),
            http("request_3")
			.get("/static/media/cart3x.d236358a.svg")
			.headers(headers_0),
            http("request_4")
			.get("/static/media/headerBot3x.db38f1aa.svg")
			.headers(headers_0),
            http("request_5")
			.get("/static/media/filter3x.4d6d6e7f.svg")
			.headers(headers_0),
            http("request_6")
			.get("/static/media/arrow3x.3aa2d735.svg")
			.headers(headers_0)))
		.pause(2)
		.exec(http("request_7")
			.get("/static/media/menu3x.34aee3ab.svg")
			.headers(headers_0)
			.resources(http("request_8")
			.get("/static/media/close@3x.3a2a3ada.svg")
			.headers(headers_0)))
		.pause(2)
		.exec(http("request_9")
			.get("/static/media/menu3x.34aee3ab.svg")
			.headers(headers_0)
			.resources(http("request_10")
			.get("/static/media/close@3x.3a2a3ada.svg")
			.headers(headers_0)))
		.pause(2)
		.exec(http("request_11")
			.get("/static/media/menu3x.34aee3ab.svg")
			.headers(headers_0)
			.resources(http("request_12")
			.get("/static/media/close@3x.3a2a3ada.svg")
			.headers(headers_0)))
		.pause(2)
		.exec(http("request_13")
			.get("/static/media/menu3x.34aee3ab.svg")
			.headers(headers_0)
			.resources(http("request_14")
			.get("/static/media/close@3x.3a2a3ada.svg")
			.headers(headers_0)))

	setUp(scn.inject(atOnceUsers(100))).protocols(httpProtocol)
}