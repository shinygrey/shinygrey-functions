(ns hello-clojure.core
  (:gen-class
   :implements [com.amazonaws.services.lambda.runtime.RequestHandler])
  (:import [com.amazonaws.services.lambda.runtime.events APIGatewayProxyResponseEvent])
  (:require [clojure.data.json :as json])
  (:require [clj-http.client :as http])
  )

(defn get-reqres
  (let [reqres (http/get "https://reqres.in/api/users/2")]
  (print (get (get (json/read-str (:body reqres)) "data") "id"))))
