(ns krell-app.core
  (:require [reagent.core :as r]
            [reagent.react-native :as rn]
            [re-frame.core :as rf]))

(defonce app-db {:counter 0})

(rf/reg-event-db
  :initialize-db
  (fn [_ _]
    app-db))

(rf/reg-event-db
  :inc-counter
  (fn [db _]
    (update db :counter inc)))

(rf/reg-sub
  :get-counter
  (fn [db _]
    (:counter db)))

(defn root []
  [rn/view {:style {:flex 1 :align-items "center" :justify-content "center"}}
   [rn/text {:style {:font-size 50}} @(rf/subscribe [:get-counter])]
   [rn/button {:title "Increment Counter"
               :on-press #(rf/dispatch [:inc-counter])}]])

(defn ^:export -main [& args]
  (rf/dispatch-sync [:initialize-db])
  (r/as-element [root]))
