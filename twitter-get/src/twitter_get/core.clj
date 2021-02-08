(ns hello-clojure.core
  (:gen-class
   :implements [com.amazonaws.services.lambda.runtime.RequestHandler])
  (:import [com.amazonaws.services.lambda.runtime.events APIGatewayProxyResponseEvent])
  (:require [clojure.data.json :as json]))

(defn lambda-integration-response [^String response-message ^long status-code]
  "Wraps message into lambda integration response object"
  (doto (new APIGatewayProxyResponseEvent)
    (.setStatusCode (int status-code))
    (.setHeaders {"Content-Type" "application/json" "Access-Control-Allow-Origin" "*"})
    (.setBody response-message)))

(defn -handleRequest
  "Returns the message"
  [this input context]
  (let [response-message (json/write-str {:message
			(str "Shiny Grey Serverless Clojure Lambda - Your function executed successfully!")})]
    (lambda-integration-response response-message 200)))
