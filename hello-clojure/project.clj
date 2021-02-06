(defproject hello-clojure "0.1.0-SNAPSHOT"
  :description "Shiny Grey first Clojure Lambda"
  :url "https://www.shinygrey.com"
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [clj-http "2.0.0"]
                 [org.clojure/data.json "1.0.0"]
                 [com.amazonaws/aws-lambda-java-core "1.2.1"]
                 [com.amazonaws/aws-lambda-java-events "3.7.0"]]
  :profiles {:dev {:dependencies [[ring/ring-devel "1.4.0"]]}}
  :jar-name "deploy-package.jar"
  :uberjar-name "deploy-package-standalone.jar"
  :main hello-clojure.core
  :aot [hello-clojure.core])
