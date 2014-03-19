class EventsController < ApplicationController
  def index
    @events = Event.page(params[:page]).per(5)
    
    respond_to do |format|
      format.html 
      format.xml { render :xml => @events.to_xml }
      format.json { render :json => @events.to_json }
      format.atom { @feed_title = "My event list"} 
    end
  end
  
  def show
    @event = Event.find(params[:id])
    respond_to do |format| 
      format.html { @page_title = @event.name }
      format.xml
      format.json {render :json => {:id => @event.id, :name => @event.name}.to_json }
    end
  end
  
  def edit
    @event = Event.find(params[:id])
  end
  
  def new
    @event = Event.new
  end
  
  def create
    @event = Event.new(params[:event])
    @event.save
    
    redirect_to events_url
  end
  
  def update
    @event = Event.find(params[:id])
    @event.update_attributes(params[:event])
    
    redirect_to event_url(@event)
  end
    
  def destroy
    @event = Event.find(params[:id])
    @event.destroy
    
    redirect_to events_url
  end
end
