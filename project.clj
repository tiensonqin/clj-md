(defproject clj-md "0.1.0-SNAPSHOT"
  :description "0MQ Majordomo Protocol Wrapper"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [org.zeromq/jeromq "0.3.3"]]
  :profiles
  {:dev {:dependencies [[re-rand "0.1.0"]
                        [compojure "1.1.6"]
                        [ring/ring-jetty-adapter "1.2.2"]
                        [clj-http "0.9.1"]
                        [cheshire "5.3.1"]]}}
  :java-source-paths ["src/jvm"])
