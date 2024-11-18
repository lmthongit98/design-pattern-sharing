package com.tma.sharing.behaviorals.mediator;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Tool {
    private boolean isUsing = false;

    public synchronized boolean canUse() {
        return !isUsing;
    }

    public synchronized void using() {
        isUsing = true;
    }

    public synchronized void done() {
        isUsing = false;
    }
}

interface Component {
    void allowUsingTool(Tool tool);

    void solve();

    String getName();
}

class Worker implements Component {

    private String name;
    private final Mediator mediator;

    public Worker(String name, Mediator mediator) {
        this.mediator = mediator;
        this.name = name;
    }

    @Override
    public void solve() {
        System.out.println(name + " needs to use tool to solve problem. He/She is asking mediator...");
        mediator.registerUsingTool(this);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void allowUsingTool(Tool tool) {
        System.out.println(name + " is using tool");
        try {
            Thread.sleep(1000); // Simulate work
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println(name + " has done its job");
        mediator.notifyDone(this);
    }
}

class Engineer implements Component {
    private final Mediator mediator;
    private String name;

    public Engineer(String name, Mediator mediator) {
        this.mediator = mediator;
        this.name = name;
    }

    @Override
    public void solve() {
        System.out.println(name + " needs to use tool to solve problem. He/She is asking mediator...");
        mediator.registerUsingTool(this);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void allowUsingTool(Tool tool) {
        System.out.println(name + " is using tool");
        try {
            Thread.sleep(1000); // Simulate work
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println(name + " has done its job");
        mediator.notifyDone(this);
    }
}

interface Mediator {
    void registerUsingTool(Component component);

    void notifyDone(Component component);

    void waitUntilDone();
}

class SimpleMediator implements Mediator {
    private final Tool tool;
    private final Queue<Component> queue = new LinkedList<>();
    private final Lock lock = new ReentrantLock();
    private final ExecutorService executorService = Executors.newFixedThreadPool(5); // Shared thread pool
    private int activeComponents = 0;

    public SimpleMediator(Tool tool) {
        this.tool = tool;
    }

    @Override
    public void registerUsingTool(Component component) {
        lock.lock();
        try {
            if (tool.canUse()) {
                allocToolForComponent(tool, component);
            } else {
                queue.add(component);
            }
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void notifyDone(Component component) {
        lock.lock();
        try {
            System.out.println(component.getName() + " notify done");
            tool.done();
            activeComponents--;
            if (!queue.isEmpty()) {
                Component nextComponent = queue.poll();
                allocToolForComponent(tool, nextComponent);
            } else if (activeComponents == 0) {
                synchronized (this) {
                    notifyAll();
                }
            }
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void waitUntilDone() {
        synchronized (this) {
            while (activeComponents > 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
        executorService.shutdown();
    }

    private void allocToolForComponent(Tool tool, Component component) {
        tool.using();
        activeComponents++;
        executorService.submit(() -> component.allowUsingTool(tool));
    }
}

public class Solution {
    public static void main(String[] args) {
        Tool sharedTool = new Tool();
        SimpleMediator mediator = new SimpleMediator(sharedTool);

        Component[] components = {
                new Worker("Worker 1", mediator), new Worker("Worker 2", mediator),
                new Worker("Worker 3", mediator), new Engineer("Engineer 1", mediator), new Engineer("Engineer 2", mediator)
        };

        for (Component component : components) {
            component.solve();
        }

        mediator.waitUntilDone();
        System.out.println("All components have done their jobs");
    }
}
