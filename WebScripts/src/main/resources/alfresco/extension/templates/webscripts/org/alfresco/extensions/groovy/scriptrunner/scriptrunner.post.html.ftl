[#ftl]
[#-- All this junk is a crude attempt at handling any output returned by the script, including sequences etc. --]
[#if scriptOutput??]
  [#if scriptOutput?is_enumerable]
    [#list scriptOutput as entry]
      [#if entry?is_enumerable]
        [#list entry as entryEntry]
          [#if entryEntry?is_enumerable]
            [#list entryEntry as entryEntryEntry]   [#-- How far should we go with these shenanigans?!? --]
              ${entryEntryEntry!}
            [/#list]
          [#else]
            ${entryEntry!}
          [/#if]
        [/#list]
      [#else]
        ${entry!}
      [/#if]
    [/#list]
  [#else]
    ${scriptOutput!}
  [/#if]
[/#if]
