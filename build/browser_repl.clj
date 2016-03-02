(require 'cljs.repl)
(require 'cljs.build.api)
(require 'cljs.repl.browser)

(cljs.build.api/build
  "src/browser"
  {:main 'browser.start.core
   :output-to "resources/browser_repl/main.js"
   :output-dir "resources/browser_repl"
   :verbose true})

(cljs.repl/repl
  (cljs.repl.browser/repl-env)
  :watch "src/browser"
  :output-dir "resources/browser_repl"
  :output-to "resources/browser_repl/main.js")
