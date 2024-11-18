package com.tma.sharing.behaviorals.mediator;

public class Problem {

    static class Tool {
        private boolean isUsing = false;

        public boolean canUse() {
            return !isUsing;
        }

        public void using() {
            isUsing = true;
        }

        public void done() {
            isUsing = false;
        }
    }

    interface ProblemSolver {
        void solve(Tool tool);
    }

    static class Worker implements ProblemSolver {
        @Override
        public void solve(Tool tool) {
            System.out.println("Worker is using tool");
            tool.using();
        }
    }

    static class Engineer implements ProblemSolver {
        @Override
        public void solve(Tool tool) {
            System.out.println("Engineer is using tool");
            tool.using();
        }
    }

    public static void main(String[] args) {
        Tool sharedTool = new Tool();

        Worker worker = new Worker();
        Engineer engineer = new Engineer();

        if (sharedTool.canUse()) {
            worker.solve(sharedTool);
        }

        if (sharedTool.canUse()) {
            engineer.solve(sharedTool);
        }

        // The engineer needs to wait for the worker to finish their job,
        // but we don't have any notifier for this.
        // Furthermore, if more users want to use the tool, we would need a queue or something similar.
    }
}
