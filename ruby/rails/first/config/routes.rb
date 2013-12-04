First::Application.routes.draw do

  root to: 'visitors#new'
  resources :contacts, only: [:new, :create]

end
