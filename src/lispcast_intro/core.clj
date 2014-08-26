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
(defn about
  [req]
  {:status 200 :body "hi my name is Jacob this site will be created in due time!" :headers {}})
(defn request
  [req]
  (println req))
(defn yo-name
  [req]
  (println req)
  {:status 200 :body (str "yo " (:list-id (:route-params req))) :headers {}})

(defn calc-it
  [{{:keys [first-num op next-num]} :route-params}]
  {:status 200
   :body (str (reduce (eval (symbol op))
                      (map #(Integer/parseInt %) [first-num next-num])))
   :headers {}})

(defroutes app
           (GET "/" [] greet)
           (GET "/calc/:first-num/:op/:next-num" [] calc-it)
           (GET "/lists/:list-id/edit" [] yo-name)
           (GET "/goodbye" [] goodbye)
           (GET "/about" [] about)
           (GET "/request" [] request)
           (not-found "Page not found!"))

(defn -main [port]
  (jetty/run-jetty app
                   {:port (Integer. port)}))

(defn -dev-main [port]
  (jetty/run-jetty (wrap-reload #'app) {:port (Integer. port)}))
