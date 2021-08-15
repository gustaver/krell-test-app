(ns krell-app.util
  (:require [re-frame.core :refer [subscribe]]))

(defn <-sub [query]
  @(subscribe query))
