(ns krell-app.subs
  (:require [re-frame.core :as rf]))

(rf/reg-sub
  :get-counter
  (fn [db _]
    (:counter db)))
