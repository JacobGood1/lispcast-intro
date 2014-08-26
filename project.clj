(defproject lispcast-intro "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [ring "1.3.1"]
                 [compojure "1.1.8"]]

  :min-lein-version "2.0.0"  ;needed for heroku

  :uberjar-name "webapp.jar" ;needed for heroku

  :main lispcast-intro.core

  :profiles {:dev
              {:main lispcast-intro.core/-dev-main}})
