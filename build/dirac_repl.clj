(require '[figwheel-sidecar.repl :as r]
         '[figwheel-sidecar.repl-api :as ra])

(ra/start-figwheel!
  {:figwheel-options  {}
   :build-ids  ["dev"]
   :all-builds
   [{:id "dev"
     :figwheel true
     :source-paths  ["src/dirac"]
     :compiler  {:main 'start.core
                 :asset-path "js"
                 :output-to "resources/public/js/app.js"
                 :output-dir "resources/public/js"
                 :source-map true
                 :verbose true}}]})

(ra/cljs-repl)