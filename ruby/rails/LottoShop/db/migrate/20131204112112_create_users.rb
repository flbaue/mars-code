class CreateUsers < ActiveRecord::Migration
  def change
    create_table :users do |t|
      t.string :firstName
      t.string :lastName
	  t.belongs_to :address
      t.timestamps
    end
  end
end
