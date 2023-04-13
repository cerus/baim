# Better Alt+Ins Menu (BAIM)

(Re)Move the new "Add dependency" action from the Alt+Insert menu.

## Huh?

One of IntelliJ's recent updates shipped a new UI and a new entry in the "Generate"-menu. This new entry is located right at the top. Everytime I want
to generate a constructor I instinctively press Alt+Ins and then Enter, which does not work anymore since the other elements have been shifted one
position lower. This is messing up my workflow.

## What this does

BAIM removes the entry from the menu. You can also optionally configure it to move the entry to the bottom instead.

## Compatibility

Tested with IntelliJ IDEA Ultimate 2023.1. No idea about other JetBrains IDEs, but this should in theory work on all IDEA based IDEs.

## Installation

BAIM is not yet available from the JetBrains Marketplace.

**Manual installation instructions**\
You can install the plugin by downloading the `baim-VERSION.zip` file from the [latest release](https://github.com/cerus/baim/releases/latest) and
clicking
the "Install plugin from disk"-button in the
IntelliJ plugins tab.

<details>
  <summary>Image</summary>
  <img src="https://i.imgur.com/SOrrDi3.png" alt="Step-by-step instructions on how to install a plugin in IntelliJ from disk"/>
</details>

## Configuration

You can find the BAIM settings in the Tools section. (File > Settings > Tools > Better Alt+Ins Menu Settings)

## Contributing

Thank you for your interest in contributing! Please open a new issue discussing what you would like to contribute, and after you've received the
approval of a maintainer you can start the work. Please follow the relevant code guidelines. (Google Java styleguide, JetBrains naming/design guides
etc.)

## License

This project is licensed under the [MIT License](https://opensource.org/license/mit/).