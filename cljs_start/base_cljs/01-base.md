!SLIDE

## Basic ClojureScript setup

Download [ClojureScript](https://github.com/clojure/clojurescript/releases/download/r1.9.473/cljs.jar) standalone jar

[rlwrap](http://utopia.knoware.nl/~hlub/uck/rlwrap/)  makes base command line repl much more usable

!SLIDE bullets incremental

# Benefits
  - Very Portable
  - Better understanding of ClojureScript
  - Less fragile

!SLIDE

# One line of bash

    @@@ bash
    java -cp cljs.jar:<cljs dir> repl.clj

# or

    @@@ bash
    lein run -m clojure.main repl.clj


!SLIDE

# Node Setup ClojureScript Setup

    @@@ clojure
    (ns start.core
      (:require [cljs.nodejs :as nodejs]))

    (nodejs/enable-util-print!)

    (defn -main  [& args]
      (println "Hello world!"))

    (set! *main-cli-fn* -main)

!SLIDE

# Node Setup

    @@@ clojure
    (require 'cljs.repl)
    (require 'cljs.build.api)
    (require 'cljs.repl.node)

    (cljs.build.api/build
      "src/node"
      {:target ':nodejs
       :output-to "node_repl/app.js"
       :output-dir "node_repl"
       :verbose true})

    (cljs.repl/repl
      (cljs.repl.node/repl-env)
      :watch "src/node"
      :output-dir "node_repl")

!SLIDE

# Browser Setup ClojureScript Side

    @@@ clojure
    (ns start.preloads
      (:require [clojure.browser.repl :as repl]))

    (defonce conn
      (repl/connect "http://localhost:9000/repl"))

    (enable-console-print!)

!SLIDE

# Browser Setup

    @@@ clojure
    (require 'cljs.repl)
    (require 'cljs.build.api)
    (require 'cljs.repl.browser)

    (cljs.build.api/build
      "src/browser"
      {:main "start.core"
       :preloads '[start.preloads]
       :output-to "browser_repl/main.js"
       :output-dir "browser_repl"
       :verbose true})

    (cljs.repl/repl
      (cljs.repl.browser/repl-env)
      :preloads '[start.preloads]
      :watch "src/browser"
      :output-dir "browser_repl"
      :output-to "browser_repl/main.js")

!SLIDE

![intermission](../../images/intermission.jpg)
