/****** Object:  Table [dbo].[users]    Script Date: 2016/6/21 14:27:36 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

SET ANSI_PADDING ON
GO

CREATE TABLE [dbo].[users](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[username] [varchar](32) NOT NULL,
	[password] [varchar](32) NOT NULL,
	[name] [varchar](10) NOT NULL,
	[sex] [bit] NOT NULL,
	[regdate] [datetime] NOT NULL,
 CONSTRAINT [PK_users] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

SET ANSI_PADDING OFF
GO

ALTER TABLE [dbo].[users] ADD  CONSTRAINT [DF_users_regdate]  DEFAULT (getdate()) FOR [regdate]
GO

