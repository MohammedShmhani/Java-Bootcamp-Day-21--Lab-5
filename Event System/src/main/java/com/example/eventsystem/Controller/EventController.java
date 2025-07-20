package com.example.eventsystem.Controller;

import com.example.eventsystem.Api.ApiResponse;
import com.example.eventsystem.Model.Event;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/event")
public class EventController {
    ArrayList<Event> events = new ArrayList<>();

    @GetMapping("/get/events")
    public ArrayList<Event> getEvents() {
        return events;
    }

    @PostMapping("/post/event")
    public ApiResponse addEvent(@RequestBody Event event) {
        events.add(event);
        return new ApiResponse("Event added successfully", "200");
    }

    @DeleteMapping("/delete/event/{index}")
    public ApiResponse deleteEvent(@PathVariable int index) {
        events.remove(index);
        return new ApiResponse("Event deleted successfully", "200");
    }

    @PutMapping("/update/event/{index}")
    public ApiResponse updateEvent(@PathVariable int index, @RequestBody Event event) {
        events.set(index, event);
        return new ApiResponse("Event updated successfully", "200");
    }

    @PutMapping("/update/capacity/event/{index}/{capacity}")
    public ApiResponse updateEventCapacity(@PathVariable int index,@PathVariable int capacity) {
        events.get(index).setCapacity(capacity);
        return new ApiResponse("Event capacity updated successfully", "200");
    }

    @GetMapping("/get/event/{id}")
    public Event getEventById(@PathVariable String id) {
        for (Event event : events) {
            if (event.getId().equals(id)) {
                return event;
            }
        }
        return null;
    }


}
