(ns clj-md.dev
  (:use clj-md.broker
        clj-md.worker
        clj-md.client)
  (:import org.zeromq.ZMsg))

;; start our broker in a future
(future (start-broker "tcp://*:5555" true))

;; create a simple echo worker
(def echo-worker (new-worker
                  "echo" "tcp://localhost:5555"
                  (fn [request reply]
                    (doall (map #(.add reply %) (.toArray request))))))

;; and run the worker
(future (run echo-worker))

;; create a client
(def echo-client (new-client "tcp://localhost:5555" false))

;; send a request, and view the response
(let [request (ZMsg.)
      _ (.addString request "some string")
      reply (send! echo-client "echo" request)]
  (= "some string" (-> (.toArray reply)
                       first
                       .toString)))
