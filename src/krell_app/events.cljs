(ns krell-app.events
  (:require
    [re-frame.core :refer [reg-event-db after]]
    [krell-app.db :refer [app-db]]))

;; -- Handlers --------------------------------------------------------------

(reg-event-db
  :initialize-db
  (fn [_ _]
    app-db))

(reg-event-db
  :inc-counter
  (fn [db [_ _]]
    (update db :counter inc)))
