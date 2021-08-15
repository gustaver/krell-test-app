(ns krell-app.util
  (:require [re-frame.core :as rf]))

(defn <-sub [query]
  @(rf/subscribe query))
