(ns lispcast-intro.core
  (require [ring.adapter.jetty :as jetty]
           [ring.middleware.reload :refer [wrap-reload]]
           [compojure.core :refer [defroutes GET]]
           [compojure.route :refer [not-found]]))

(defn greet
  [request]
  {:status 200 :body "Hell Werld!" :headers {}})
(defn goodbye
  [req]
  {:status 200 :body "goodbye cruel werld!" :headers {}})

(defroutes app
           (GET "/" [] greet)
           (GET "/goodbye" [] goodbye)
           (not-found "Page not found!"))

(defn -main [port]
  (jetty/run-jetty app
                   {:port (Integer. port)}))

(defn -dev-main [port]
  (jetty/run-jetty (wrap-reload #'app) {:port (Integer. port)}))
