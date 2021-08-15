(ns krell-app.events
  (:require [re-frame.core :as rf]
            [krell-app.db :refer [app-db]]))

(rf/reg-event-db
  :initialize-db
  (fn [_ _]
    app-db))

(rf/reg-event-db
  :inc-counter
  (fn [db _]
    (update db :counter inc)))
